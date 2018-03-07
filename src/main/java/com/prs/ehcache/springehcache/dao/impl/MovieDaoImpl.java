package com.prs.ehcache.springehcache.dao.impl;

import com.prs.ehcache.springehcache.dao.MovieDao;
import com.prs.ehcache.springehcache.dto.Movie;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao {

    //each call will delay 2 seconds, simulate the slow query call
    @Cacheable(value="movieFindCache", key="#x")
    public Movie findByDirector(String x) {
        slowQuery(2000L);
        System.out.println("findByDirector is running...");
        return new Movie(1,"Forrest Gump","Robert Zemeckis");
    }

    private void slowQuery(long seconds){
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
