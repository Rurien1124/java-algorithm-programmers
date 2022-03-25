package com.gng.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 * @author gchyoo
 *
 */
public class UserReport {
	
	/**
	 * 
	 * @param idList ����� ���̵� �迭
	 * @param report ��
	 * @param reportThreshold
	 * @return
	 */
	public static List<Integer> solution(String[] idList, String[] reports, int reportThreshold) {
		/**
		 * �� ������ �Ű� ��븦 �ߺ� ���� ��� ���� Map/Set ���
		 * ��� ��� �� ���� ������ �ʿ��ϹǷ� LinkedHashMap ���
		 */
		// �Ű��� ��� ��
		Map<String, Set<String>> reporterMap = new LinkedHashMap<>();
		// �Ű�� ��� ��
		Map<String, Set<String>> reportedMap = new LinkedHashMap<>();
		
		
		Arrays.asList(idList).forEach(id -> {
			// Set�� �Է¹��� id�� ������� �ʱ�ȭ
			reporterMap.put(id, new HashSet<>());
			reportedMap.put(id, new HashSet<>());
		});
		
		Arrays.asList(reports).forEach(report -> {
			String[] reportSplit = report.split(" ");
			String reporterId = reportSplit[0];
			String reportedId = reportSplit[1];
			
			// �Ű��� ��� ó��
			Set<String> previousReporterIdSet = reporterMap.get(reporterId);
			previousReporterIdSet.add(reportedId);

			// �Ű��� ����� Map�� ������Ʈ
			reporterMap.put(reporterId, previousReporterIdSet);
			
			// �Ű�� ��� ó��
			Set<String> previousReportedIdSet = reportedMap.get(reportedId);
			previousReportedIdSet.add(reporterId);
			
			// �Ű�� ����� Map�� ������Ʈ
			reportedMap.put(reportedId, previousReportedIdSet);
		});
		
		// �Ű� ����� ���� ����Ʈ
		List<Integer> reportCountList = IntStream.of(new int[idList.length])
				.boxed()
				.collect(Collectors.toList());

		// �Ű� Ƚ���� ����Ʈ ���·� ����
		reportedMap.keySet().forEach(reportedId -> {
					// ���� Ƚ�� ����
					int reportedCount = reportedMap.get(reportedId).size() - (reportThreshold - 1);

					// ���� ������� Ȯ��
					if(reportedCount > 0) {
						AtomicInteger index = new AtomicInteger();
						
						reporterMap.keySet().forEach(reporterId -> {
							if(reporterMap.get(reporterId).contains(reportedId)) {
								// �Ű����� Set�� ������ ����� ������ + 1
								reportCountList.set(index.get(), reportCountList.get(index.get()) + 1);
							}
							
							index.set(index.get() + 1);
						});
					}
				});
		
		return reportCountList;
	}
	
	public static void main(String[] args) {
		String[] idList1 = {"muzi", "frodo", "apeach", "neo"};
		String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
		int reportThreshold1 = 2;
		
		String[] idList2 = {"con", "ryan"};
		String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int reportThreshold2 = 3;
		
		System.out.println(solution(idList1, report1, reportThreshold1));
	}
}
