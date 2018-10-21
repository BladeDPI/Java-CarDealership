/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international
 * treaties. Unauthorized reproduction or distribution of this program,
 * or any portion of it, may result in severe civil and criminal penalties,
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
package edu.wk.blog.dao.jpa;

import edu.wk.blog.dao.BlogPostDao;
import edu.wk.blog.dao.RepositoryException;
import edu.wk.blog.model.BlogPost;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.Collection;

@ApplicationScoped
public class BlogPostJpaDao extends AbstractJpaDao<BlogPost> implements BlogPostDao {

    public BlogPostJpaDao() {
        super(BlogPost.class);
    }

    @Override
    public Collection<BlogPost> findByTitle(String title) throws RepositoryException {
        TypedQuery<BlogPost> query = entityManager.createNamedQuery(BlogPost.FIND_BY_TITLE, BlogPost.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
