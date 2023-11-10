package com.example.redditproject.services;

import com.example.redditproject.repositories.RepositoryTrend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrendService{

    @Autowired
    private RepositoryTrend repositoryTrend = new RepositoryTrend() {
        @Override
        public Object save(Object entity) {
            return null;
        }

        @Override
        public Iterable saveAll(Iterable entities) {
            return null;
        }

        @Override
        public Optional findById(Object o) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Object o) {
            return false;
        }

        @Override
        public Iterable findAll() {
            return null;
        }

        @Override
        public Iterable findAllById(Iterable iterable) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Object o) {

        }

        @Override
        public void delete(Object entity) {

        }

        @Override
        public void deleteAllById(Iterable iterable) {

        }

        @Override
        public void deleteAll(Iterable entities) {

        }

        @Override
        public void deleteAll() {

        }
    };


}
