package com.example.test.basic.algorithm.kakao;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] idList = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;

//        String[] idList = { "con", "ryan" };
//        String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
//        int k = 3;


        int[] solution = new Solution().solution(idList, report, k);
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            Accounts accounts = Accounts.of(Arrays.stream(id_list)
                    .map(Account::create)
                    .collect(toList()));

            Arrays.stream(report)
                    .map(s -> s.split(" "))
                    .forEach(reports -> accounts.getAccountByName(reports[0])
                            .report(accounts.getAccountByName(reports[1])));

            return accounts.receiveResult(k);
        }
    }

}
