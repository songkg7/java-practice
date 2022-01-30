package com.example.test.basic.algorithm.kakao;

import static java.util.stream.Collectors.toList;

import com.example.test.basic.algorithm.kakao.domain.Account;
import com.example.test.basic.algorithm.kakao.domain.Accounts;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] idList = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;

        int[] solution = new Solution().solution(idList, report, k);
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int limitCount) {
            Accounts accounts = Accounts.of(Arrays.stream(id_list)
                    .map(name -> Account.create(name, limitCount))
                    .collect(toList()));

            Arrays.stream(report)
                    .map(s -> s.split(" "))
                    .forEach(reports -> accounts.getAccountByName(reports[0])
                            .report(accounts.getAccountByName(reports[1])));

            return accounts.resultByBanLimit();
        }
    }

}
