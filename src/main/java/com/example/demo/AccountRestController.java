package com.example.demo;


import com.example.demo.ResponseForm;
import com.example.demo.board.BoardDo;
import com.example.demo.board.PostForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@RestController
@EnableSwagger2
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/accounts")
    public Page<AccountDo> getListOfAccount(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {

        return accountService.list(page, size);
    }

    @GetMapping(value = "/accounts/{account_id}")
    public AccountDo getAccount (@PathVariable("account_id") Long account_id){
    PostForm postForm1 = new PostForm();
        return accountService.getAccount(account_id);

    }

    @PutMapping(value = "/accounts/{account_id}")
    public AccountDo getAccount(@PathVariable("account_id") Long board_id, @RequestBody AccountDo accountDo){

        AccountDo accountDo1 = this.accountService.save(accountDo);
        return accountDo1;
    }

    @PostMapping(value = "/boards")
    public AccountDo NewPost(@RequestBody AccountDo accountDo) {

        AccountDo accountDo1 = this.accountService.save(accountDo);

        return accountDo1;
    }
}
