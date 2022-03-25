package com.gng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * @author gchyoo
 *
 */
public class OpenChat {
	
	public List<String> solution(String[] records) {
		List<String> recordList = Arrays.asList(records);

		// RecordObj�� uid�� �ϳ��� �����ϵ��� �ϱ� ���� ��
		Map<String, RecordObj> createdUidMap = new HashMap<>();
		
		for(int index=0; index < recordList.size(); index++) {
			String record = recordList.get(index);
			String uid = RecordObj.getUidFromString(record);
			
			// �ش� uid�� RecordObj�� ������ ����
			if(!createdUidMap.containsKey(uid)) {
				createdUidMap.put(uid, new RecordObj());
			}
			
			// ��ɾ� �Է�
			RecordObj recordObj = createdUidMap.get(uid);
			recordObj.addRecord(index, record);
		}
		
		// �޽��� ��ü�� ����Ʈ
		List<MessageObj> messageObjList = createdUidMap.keySet().stream()
				.map(uid -> createdUidMap.get(uid))
				.map(recordObj -> recordObj.getAllMessageObj())
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		Collections.sort(messageObjList, new MessageObjComparator().reversed());
		
		return messageObjList.stream()
				.map(messageObj -> messageObj.getMessage())
				.collect(Collectors.toList());
	}
	
	public static class RecordObj {
		private List<Integer> messageIndexList = new ArrayList<>();
		private List<CommandType> commandList = new ArrayList<>();
		private String uid;
		private String name;
		
		public void addRecord(int index, String record) {
			// ��ɾ� ����
			String[] recordSplit = record.split(" ");
			CommandType commandType = CommandType.of(recordSplit[0]);
			
			uid = recordSplit[1];
			
			if((recordSplit.length > 2 && name == null) 
					|| (commandType.equals(CommandType.COMMAND_CHANGE) || commandType.equals(CommandType.COMMAND_ENTER))) {
				name = recordSplit[2];
			}
			
			if(!commandType.equals(CommandType.COMMAND_CHANGE)){
				// ���� ����� �ε���/��� ����
				messageIndexList.add(index);
				commandList.add(commandType);
			}
		}
		
		@Override
		public String toString() {
			return messageIndexList + "\n" + commandList + "\n" + uid + "\n" + name + "\n----------------\n";
		}
		
		/**
		 * �޽������� uid ��������
		 * @param records
		 * @return
		 */
		public static String getUidFromString(String records) {
			String[] recordSplit = records.split(" ");
			
			return recordSplit[1];
		}
		
		/**
		 * ��ü �޽��� ��ü ��ȯ
		 * @param index
		 * @return
		 */
		public List<MessageObj> getAllMessageObj() {
			List<MessageObj> messageObjList = new ArrayList<>();
			
			for(int index=0; index < messageIndexList.size(); index++) {
				int messageIndex = messageIndexList.get(index);
				
				messageObjList.add(new MessageObj(messageIndex, name, commandList.get(index)));
			}
			
			return messageObjList;
		}
		
		public List<Integer> getMessageIndexList(int index) {			return messageIndexList;		}
		public String getUid() {			return uid;		}
		public void setUid(String currentUid) {			this.uid = currentUid;		}
		public String getName() {			return name;		}
		public void setName(String name) {			this.name = name;		}
	
	}

	public static class MessageObj {
		private int index;
		private String name;
		private CommandType commandType;
		
		public MessageObj(int index, String name, CommandType commandType) {
			this.index = index;
			this.name = name;
			this.commandType = commandType;
		}
		
		public int getIndex() {			return index;		}
		public String getMessage() {
			return this.name + this.commandType.getMessage();
		}
	}

	public class MessageObjComparator implements Comparator<MessageObj> {
		@Override
		public int compare(MessageObj messageObj1, MessageObj messageObj2) {
		if (messageObj1.index < messageObj2.index) {
			return 1;
		} else if (messageObj1.index > messageObj2.index) {
			return -1;
		}
			return 0;
		}
	}
	
	public enum CommandType {
		COMMAND_ENTER("Enter", "���� ���Խ��ϴ�."),
		COMMAND_LEAVE("Leave", "���� �������ϴ�."),
		COMMAND_CHANGE("Change", "");
		
		private String command;
		private String message;
		
		private CommandType(String command, String message) {
			this.command = command;
			this.message = message;
		}
		
		public static CommandType of(String command) {
			for(CommandType commandType : CommandType.values()) {
				if(commandType.getCommand().equals(command)) {
					return commandType;
				}
			}
			
			return null;
		}
		
		public String getCommand() {			return command;		}
		public String getMessage() {			return message;		}
	}
	
	public static void main(String[] args) {
		String[] records = {
					"Enter uid1234 Muzi",
					"Enter uid4567 Prodo",
					"Leave uid1234",
					"Enter uid1234 Prodo",
					"Change uid4567 Ryan",
					"Leave uid4567"
				};
		
		System.out.println(new OpenChat().solution(records));
	}
}
