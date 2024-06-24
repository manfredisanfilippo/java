package com.example.gokart.controller_app;

import com.example.gokart.bean.LeadboardBean;
import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.SubscriptionBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.dao.SubscriptionDao;
import com.example.gokart.entity.Leadbord;
import com.example.gokart.entity.Subscription;
import com.example.gokart.entity.Tournament;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionControllerApp {

    public static void subscription(LoginBean loginbean, TournamentBean tournamentBean) throws Exception {
        try {
            SubscriptionDao subscriptionDao = new SubscriptionDao();
            subscriptionDao.subscription(loginbean, tournamentBean);

            System.out.print("You have subscription and pay");
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<TournamentBean> getAllSubscriptions(int id) {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        var tournamentList = subscriptionDao.getAllSubscriptions(id);
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

    public static List<LeadboardBean> GetLeadboard() {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        List<LeadboardBean> leadboardBeans = new ArrayList<>();
        var leadBoardList = subscriptionDao.GetLeadboard();
        for (Leadbord leadboard : leadBoardList) {
            var driver = leadboard.getDriver();
            var numberRace = leadboard.getNumberRace();
            var totalPoint = leadboard.getTotalPoint();
            LeadboardBean leadboardBean = new LeadboardBean(driver, numberRace, totalPoint);
            leadboardBeans.add(leadboardBean);
        }
        return leadboardBeans;
    }

    public static List<SubscriptionBean> GetTournamentSubscription(TournamentBean tournamentBean) {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        List<SubscriptionBean> subscriptionBeans = new ArrayList<>();
        var subscriptionList = subscriptionDao.GetTournamentSubscription(tournamentBean);
        for (Subscription subscription : subscriptionList) {
            var driver = subscription.getDriver();
            var tournament = subscription.getTournament();
            var driverId = subscription.getIdDriver();
            var tournamentId = subscription.getIdTournament();
            var vote = subscription.getVote();
            SubscriptionBean subscriptionBean = new SubscriptionBean(driverId, tournamentId, vote, driver,tournament);
            subscriptionBeans.add(subscriptionBean);
        }
        return subscriptionBeans;
    }
}
