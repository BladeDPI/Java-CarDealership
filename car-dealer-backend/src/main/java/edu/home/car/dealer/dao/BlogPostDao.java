package edu.home.car.dealer.dao;

import edu.home.car.dealer.model.BlogPost;

import java.util.Collection;

public interface BlogPostDao extends  Dao<BlogPost> {

    // CRUD methods specific to this entity
    Collection<BlogPost> findByTitle(String title);
}
