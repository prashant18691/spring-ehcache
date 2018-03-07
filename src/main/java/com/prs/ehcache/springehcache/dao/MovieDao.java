package com.prs.ehcache.springehcache.dao;

import com.prs.ehcache.springehcache.dto.Movie;

public interface MovieDao {
    Movie findByDirector(String name);
}
