package com.example.gokart.controller_app;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.dao.TournamentDao;
import com.example.gokart.entity.Tournament;

import java.util.ArrayList;
import java.util.List;

public class TournamentControllerApp {

    public static void createTournament(LoginBean login, TournamentBean tournament) throws Exception {
        try
        {
            TournamentDao tournamentDao = new TournamentDao();
            Tournament entity = new Tournament(tournament.getName(), tournament.getWhere(), tournament.getNumber(), tournament.getCost(),tournament.getDate(), login.getUsername());
            tournamentDao.createTournament(entity);
        }
        catch (Exception e){
            throw e;
        }
    }

    public static List<TournamentBean> GetAllMyTournament(Integer id) throws Exception {
        TournamentDao tournamentDao = new TournamentDao();
        List<Tournament> tournamentList = tournamentDao.getAllByAdminIdTournaments(id);
        List<TournamentBean> tournamentBeans = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            var Id = tournament.getId();
            var name = tournament.getName();
            var where = tournament.getWhere();
            var number = tournament.getNumber();
            var cost = tournament.getCost();
            var date = tournament.getDate();
            TournamentBean tournamentBean = new TournamentBean(Id, name, where, number, cost, date);
            tournamentBeans.add(tournamentBean);
        }
        return tournamentBeans;
    }

    public static List<TournamentBean> GetAllTournament() throws Exception {
        TournamentDao tournamentDao = new TournamentDao();
        List<Tournament> tournamentList = tournamentDao.getAllTournaments();
        List<TournamentBean> tournamentBeans = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            var Id = tournament.getId();
            var name = tournament.getName();
            var where = tournament.getWhere();
            var number = tournament.getNumber();
            var cost = tournament.getCost();
            var date = tournament.getDate();
            TournamentBean tournamentBean = new TournamentBean(Id, name, where, number, cost, date);
            tournamentBeans.add(tournamentBean);
        }
        return tournamentBeans;
    }
}
