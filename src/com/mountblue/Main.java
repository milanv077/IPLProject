package com.mountblue;

import java.util.*;
import static com.mountblue.Constants.*;

public class Main {

    static List<Match> listOfMatch;
    static List<Delivery> listOfDeliveries;
    public static void main(String[] args) throws Exception {

        Util u=new Util();
        listOfMatch=u.getMatchesDatabase();
        listOfDeliveries = u.getDeliveriesDatabase();

        System.out.println(findNoOfMatchesPlayedPerYear(listOfMatch));
        System.out.println(findMatchesWonByTeam(listOfMatch));
        System.out.println(findExtraRunByEachTeam(listOfMatch,listOfDeliveries));
        System.out.println(findEconomicalBowler(listOfDeliveries,listOfMatch));
    }
     static Map<String, Double> findEconomicalBowler(List<Delivery> listOfDeliveries, List<Match> listOfMatch) {
        Map<String, Integer> overCountOfBowler = new LinkedHashMap<String, Integer>();
        Map<String, Integer> totalRunGivenByBowler = new LinkedHashMap<String, Integer>();
        Map<String, Double> averageOfEachBowler = new LinkedHashMap<String, Double>();
        Map<String, Double> topEconomicalBowler = new LinkedHashMap<String, Double>();

        for (int i = 0; i < listOfMatch.size(); i++) {
            if (listOfMatch.get(i).getSeason() == SEASON_2015) {
                String prev = "";
                String current = "";
                for (int j = 0; j < listOfDeliveries.size(); j++) {
                    if (listOfDeliveries.get(j).getMatchId() == listOfMatch.get(i).getId()) {
                        current = listOfDeliveries.get(j).getBowler();

                        if (!prev.equals(current)) {
                            prev = current;
                            if (!overCountOfBowler.containsKey(current)) {
                                overCountOfBowler.put(current, COUNT);

                            } else {
                                overCountOfBowler.put(current, overCountOfBowler.get(current) + COUNT);
                            }
                        }
                        if (!totalRunGivenByBowler.containsKey(current)) {
                            int sum = listOfDeliveries.get(j).getTotalRuns();
                            totalRunGivenByBowler.put(current, sum);
                        } else {

                            int sum2 = totalRunGivenByBowler.get(current) + listOfDeliveries.get(j).getTotalRuns();
                            totalRunGivenByBowler.put(current, sum2);
                        }
                    }
                }
            }
        }

        for(Map.Entry<String, Integer> overCount:overCountOfBowler.entrySet()) {
            double averageOFBowler=(double)totalRunGivenByBowler.get(overCount.getKey())/overCountOfBowler.get(overCount.getKey());
            averageOfEachBowler.put(overCount.getKey(),averageOFBowler);
        }


        double minAverage=Double.MAX_VALUE;
        String bowlerName="";
        for (Map.Entry<String,Double> averageOfBowler:averageOfEachBowler.entrySet()) {
            if(minAverage>averageOfEachBowler.get(averageOfBowler.getKey())) {
                minAverage=averageOfEachBowler.get(averageOfBowler.getKey());
                bowlerName=averageOfBowler.getKey();
            }
        }
        topEconomicalBowler.put(bowlerName,minAverage);
        return topEconomicalBowler;
    }
     static Map<String, Integer> findMatchesWonByTeam(List<Match> listOfMatch) {
        Map<String,Integer> matchesWonByTeam=new LinkedHashMap<String,Integer>();
        for(int i=0;i<listOfMatch.size();i++) {
            String winnerTeam=listOfMatch.get(i).getWinner();
            if(!matchesWonByTeam.containsKey(winnerTeam)) {
                matchesWonByTeam.put(winnerTeam,COUNT);
            } else {
                matchesWonByTeam.put(winnerTeam,matchesWonByTeam.get(winnerTeam)+COUNT);
            }
        }

        return matchesWonByTeam;
    }
     static Map<String, Integer> findExtraRunByEachTeam(List<Match> listOfMatch, List<Delivery> listOfDeliveries) {
        Map<String, Integer> runGivenByTeamIn2016 = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < listOfMatch.size(); i++) {
            if (listOfMatch.get(i).getSeason() == SEASON_2016) {
                for (int j = 0; j < listOfDeliveries.size(); j++) {
                    if (listOfDeliveries.get(j).getMatchId() == listOfMatch.get(i).getId()) {
                        String bowlingTeam = listOfDeliveries.get(j).getBowlingTeam();
                        int runGivenByBowlingTeam = listOfDeliveries.get(j).getExtraRuns();
                        if (!runGivenByTeamIn2016.containsKey(bowlingTeam)) {
                            runGivenByTeamIn2016.put(bowlingTeam, runGivenByBowlingTeam);
                        } else {
                            int totalRunGivenByBowlingTeam = runGivenByTeamIn2016.get(bowlingTeam) + listOfDeliveries.get(j).getExtraRuns();
                            runGivenByTeamIn2016.put(bowlingTeam, totalRunGivenByBowlingTeam);
                        }
                    }
                }
            }
        }

        return runGivenByTeamIn2016;
    }
     static Map<Integer, Integer> findNoOfMatchesPlayedPerYear(List<Match> listOfMatch) {
        Map<Integer,Integer>  matchesPlayedPerYear=new LinkedHashMap<Integer, Integer>();
        for(int i=0;i<listOfMatch.size();i++) {
            int year=listOfMatch.get(i).getSeason();
             if(!matchesPlayedPerYear.containsKey(year)) {
                    matchesPlayedPerYear.put(year,COUNT);
             } else {
                 matchesPlayedPerYear.put(year,matchesPlayedPerYear.get(year)+COUNT);
             }
        }
        return matchesPlayedPerYear;
    }

}
