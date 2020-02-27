package com.mountblue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Util implements Constans{

    public BufferedReader readFile(String path) throws Exception {
        FileReader fileReader=new FileReader(path);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        return bufferedReader;
    }
    List<Match> getMatchesDatabase() throws Exception {
        BufferedReader bufferedReader=readFile(PATH_OF_MATCHES);
        String line=bufferedReader.readLine();
        List<Match> listOfMatch=new ArrayList<Match>();
        while((line=bufferedReader.readLine())!=null){
            String[] value = line.replaceAll(",",", ").split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            Match match=new Match();
            match.setId(Integer.parseInt(value[ID_INDEX].toString().trim()));
            match.setSeason(Integer.parseInt(value[SEASON_INDEX].toString().trim()));
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
        BufferedReader bufferedReader = readFile(PATH_OF_DELIVERIES);
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
