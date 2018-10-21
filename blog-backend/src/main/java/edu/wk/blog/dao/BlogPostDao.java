package edu.wk.blog.dao;

import edu.wk.blog.model.BlogPost;

import java.util.Collection;

public interface BlogPostDao extends  Dao<BlogPost> {

    // CRUD methods specific to this entity
    Collection<BlogPost> findByTitle(String title);
}
