package com.ipl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util {


    private static final int ID_INDEX = 0;
    private static final int SESSION_INDEX = 1;
    private static final int CITY_INDEX = 2;
    private static final int DATE_INDEX = 3;
    private static final int TEAM1_INDEX =4 ;
    private static final int TEAM2_INDEX = 5;
    private static final int TOSS_WINNER_INDEX = 6;
    private static final int TOSS_DECISION_INDEX = 7;
    private static final int RESULT_INDEX =8 ;
    private static final int DL_APLLIED = 9;
    private static final int WINNER_INDEX = 10;
    private static final int WIN_BY_RUNS_INDEX = 11;
    private static final int WIN_BY_WICKETS_INDEX = 12;
    private static final int PLAYER_OF_MATCH_INDEX = 13;
    private static final int VENUE_INDEX = 14;
    private static final int UMPIRE1_INDEX = 15;
    private static final int UMPIRE2_INDEX = 16;

    private static final int MATCH_ID = 0;
    private static final int INNING_INDEX = 1;
    private static final int BATTING_TEAM_INDEX = 2;
    private static final int BOWLING_TEAM_INDEX =3 ;
    private static final int OVER_INDEX = 4;
    private static final int BALL_INDEX = 5;
    private static final int BATSMAN_INDEX = 6;
    private static final int NON_STRIKER_INDEX = 7;
    private static final int BOWLER_INDEX = 8;
    private static final int IS_SUPER_OVER_INDEX = 9;
    private static final int WIDE_RUNS = 10;
    private static final int BYE_RUN_INDEX = 11;
    private static final int LEGBYE_INDEX = 12;
    private static final int NOBALL_INDEX = 13;
    private static final int PENALTY_INDEX = 14;
    private static final int BATSMAN_RUNS_INDEX = 15;
    private static final int EXTRA_RUNS_INDEX = 16;
    private static final int TOTAL_RUNS_INDEX = 17;
    private static final int PLAYER_DISMISSED_INDEX = 18;
    private static final int DISMISSAL_KIND_INDEX = 19;
    private static final int FIELDER_INDEX = 20;

    public BufferedReader readFile(String path) throws Exception {
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        return bufferedReader;
    }
    List<Match> getMatchesDatabase() throws Exception {
        String path="matches.csv";
        BufferedReader bufferedReader=readFile(path);
        String line=bufferedReader.readLine();
        List<Match> listOfMatch=new ArrayList<Match>();
        while((line=bufferedReader.readLine())!=null){
            String[] value = line.replaceAll(",",", ").split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            Match match=new Match();
            match.setId(Integer.parseInt(value[ID_INDEX].toString().trim()));
            match.setSeason(Integer.parseInt(value[SESSION_INDEX].toString().trim()));
            match.setCity(value[CITY_INDEX]);
            match.setDate((value[DATE_INDEX].toString().trim()));
            match.setTeam1(value[TEAM1_INDEX]);
            match.setTeam2(value[TEAM2_INDEX]);
            match.setTossWinner(value[TOSS_WINNER_INDEX]);
            match.setTossDecision(value[TOSS_DECISION_INDEX]);
            match.setResult(value[RESULT_INDEX]);
            match.setDlApplied(Integer.parseInt(value[DL_APLLIED].toString().trim()));
            match.setWinner(value[WINNER_INDEX]);
            match.setWinByRuns(Integer.parseInt(value[WIN_BY_RUNS_INDEX].toString().trim()));
            match.setWinByWickets(Integer.parseInt(value[WIN_BY_WICKETS_INDEX].toString().trim()));
            match.setPlayerOfMatch(value[PLAYER_OF_MATCH_INDEX]);
            match.setVenue(value[VENUE_INDEX]);
            match.setUmpire1(value[UMPIRE1_INDEX]);
            match.setUmpire2(value[UMPIRE2_INDEX]);

            listOfMatch.add(match);
        }

        return listOfMatch;
    }
    List<Delivery> getDeliveriesDatabase() throws Exception {

        String path = "deliveries.csv";
        BufferedReader bufferedReader = readFile(path);
        String line = bufferedReader.readLine();
        List<Delivery> listOfDelivery = new ArrayList<Delivery>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] value = line.replaceAll(",",", ").split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            Delivery delivery = new Delivery();

            delivery.setMatchId(Integer.parseInt(value[MATCH_ID].toString().trim()));
            delivery.setInning(Integer.parseInt(value[INNING_INDEX].toString().trim()));
            delivery.setBattingTeam(value[BATTING_TEAM_INDEX]);
            delivery.setBowlingTeam(value[BOWLING_TEAM_INDEX]);
            delivery.setOver(Integer.parseInt(value[OVER_INDEX].toString().trim()));
            delivery.setBall(Integer.parseInt(value[BALL_INDEX].toString().trim()));
            delivery.setBatsman(value[BATSMAN_INDEX]);
            delivery.setNonStriker(value[NON_STRIKER_INDEX]);
            delivery.setBowler(value[BOWLER_INDEX]);
            delivery.setIsSuperOver(Integer.parseInt(value[IS_SUPER_OVER_INDEX].toString().trim()));
            delivery.setWideRuns(Integer.parseInt(value[WIDE_RUNS].toString().trim()));
            delivery.setByeRuns(Integer.parseInt(value[BYE_RUN_INDEX].toString().trim()));
            delivery.setLegbyeRuns(Integer.parseInt(value[LEGBYE_INDEX].toString().trim()));
            delivery.setNoballRuns(Integer.parseInt(value[NOBALL_INDEX].toString().trim()));
            delivery.setPenaltyRuns(Integer.parseInt(value[PENALTY_INDEX].toString().trim()));
            delivery.setBatsmanRuns(Integer.parseInt(value[BATSMAN_RUNS_INDEX].toString().trim()));
            delivery.setExtraRuns(Integer.parseInt(value[EXTRA_RUNS_INDEX].toString().trim()));
            delivery.setTotalRuns(Integer.parseInt(value[TOTAL_RUNS_INDEX].toString().trim()));
            delivery.setPlayerDismissed(value[PLAYER_DISMISSED_INDEX]);
            delivery.setDismissalKind(value[DISMISSAL_KIND_INDEX]);
            delivery.setFielder(value[FIELDER_INDEX]);

            listOfDelivery.add(delivery);
        }
        return listOfDelivery;
    }
}
