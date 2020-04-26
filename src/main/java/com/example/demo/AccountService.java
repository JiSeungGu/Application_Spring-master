package com.example.demo;


import com.example.demo.board.BoardDo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Page<AccountDo> list(int page, int size) {

            return accountDao.findAll(PageRequest.of(page, size));
    }
    public AccountDo save(AccountDo accountDo) {

        return this.accountDao.save(accountDo);
    }


    public AccountDo getAccount(Long account_id) {

        return accountDao.getOne(account_id);
    }
}