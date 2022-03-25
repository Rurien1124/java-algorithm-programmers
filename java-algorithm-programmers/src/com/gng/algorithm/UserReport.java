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
	 * @param idList 사용자 아이디 배열
	 * @param report 신
	 * @param reportThreshold
	 * @return
	 */
	public static List<Integer> solution(String[] idList, String[] reports, int reportThreshold) {
		/**
		 * 각 유저의 신고 상대를 중복 없이 담기 위해 Map/Set 사용
		 * 결과 출력 시 순서 보장이 필요하므로 LinkedHashMap 사용
		 */
		// 신고한 사람 맵
		Map<String, Set<String>> reporterMap = new LinkedHashMap<>();
		// 신고된 사람 맵
		Map<String, Set<String>> reportedMap = new LinkedHashMap<>();
		
		
		Arrays.asList(idList).forEach(id -> {
			// Set을 입력받은 id의 순서대로 초기화
			reporterMap.put(id, new HashSet<>());
			reportedMap.put(id, new HashSet<>());
		});
		
		Arrays.asList(reports).forEach(report -> {
			String[] reportSplit = report.split(" ");
			String reporterId = reportSplit[0];
			String reportedId = reportSplit[1];
			
			// 신고한 사람 처리
			Set<String> previousReporterIdSet = reporterMap.get(reporterId);
			previousReporterIdSet.add(reportedId);

			// 신고한 사람의 Map을 업데이트
			reporterMap.put(reporterId, previousReporterIdSet);
			
			// 신고된 상대 처리
			Set<String> previousReportedIdSet = reportedMap.get(reportedId);
			previousReportedIdSet.add(reporterId);
			
			// 신고된 상대의 Map을 업데이트
			reportedMap.put(reportedId, previousReportedIdSet);
		});
		
		// 신고 결과를 담을 리스트
		List<Integer> reportCountList = IntStream.of(new int[idList.length])
				.boxed()
				.collect(Collectors.toList());

		// 신고 횟수를 리스트 형태로 변경
		reportedMap.keySet().forEach(reportedId -> {
					// 정지 횟수 적용
					int reportedCount = reportedMap.get(reportedId).size() - (reportThreshold - 1);

					// 정지 대상인지 확인
					if(reportedCount > 0) {
						AtomicInteger index = new AtomicInteger();
						
						reporterMap.keySet().forEach(reporterId -> {
							if(reporterMap.get(reporterId).contains(reportedId)) {
								// 신고자의 Set에 정지된 대상이 있으면 + 1
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
