package com.project.dogwalkfriend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.project.dogwalkfriend.service.DogService;
import com.project.dogwalkfriend.service.FriendService;
import com.project.dogwalkfriend.service.MemberService;
import com.project.dogwalkfriend.service.NoticeService;
import com.project.dogwalkfriend.service.WalkService;

@Controller
public class AdminController {
	@Autowired
	private DogService ds;
	@Autowired
	private FriendService fs;
	@Autowired
	private MemberService ms;
	@Autowired
	private NoticeService ns;
	@Autowired
	private WalkService ws;
}
