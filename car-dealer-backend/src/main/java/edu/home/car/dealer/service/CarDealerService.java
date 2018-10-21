package edu.home.car.dealer.service;

import edu.home.car.dealer.model.CarDeal;

import java.util.Collection;

public interface CarDealerService {

    Collection<CarDeal> findAllBlogPosts() throws ServiceException;

    CarDeal findBlogPostById(Long id) throws ServiceException;

    void createBlogPost(CarDeal carDeal) throws ServiceException;

    Collection<CarDeal> findBlogPostByTitle(String title) throws ServiceException;
}
