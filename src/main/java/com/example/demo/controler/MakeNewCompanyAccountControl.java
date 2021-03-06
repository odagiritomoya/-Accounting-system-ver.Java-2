package com.example.demo.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.constant.Authority;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.CompanyAccountEntity;
import com.example.demo.form.MakeNewComanyAccountForm;
import com.example.demo.repository.MakeNewCompanyAccountMapper;

@Controller
@RequestMapping(MakeNewCompanyAccountControl.PAGE_URL)
public class MakeNewCompanyAccountControl {	
	//定数群
	private final String defaultAuthority = Authority.MASTER;
	public static final String PAGE_URL = "/makeNewCompanyAccount";
	
	@Autowired
	MakeNewCompanyAccountMapper mapper;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping
	public String showDisplay( MakeNewComanyAccountForm form,Model model) {
		return PAGE_URL;
	}
	@PostMapping("make")
	public String insertCompanyAccount(@Valid MakeNewComanyAccountForm form,BindingResult bindingResult, Model model) {
		//入力ﾁｪｯｸでエラーがある場合は、何もしないでこの関数を終わる
		if (bindingResult.hasErrors())
			return PAGE_URL;
		
		//各種Formオブジェクト作成
		UserDto user = new UserDto(form,encoder);
		CompanyAccountEntity company = new CompanyAccountEntity(form);
		
		//会社の登録
		mapper.getNewCompanyAccountId(company);
		mapper.insertCompanyAccount(company);
		
		//ユーザーの登録
		user.setAuthority(defaultAuthority);
		user.setCompanyId( company.getCompanyId() );
		mapper.insertUser(user);
		
		//結果のセット
		model.addAttribute("userId",user.getUserid());
		model.addAttribute("companyId",user.getCompanyId());
		return "/resultMakeNewCompanyAccount";
	}
}