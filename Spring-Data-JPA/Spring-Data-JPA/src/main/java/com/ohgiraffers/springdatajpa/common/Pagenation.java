package com.ohgiraffers.springdatajpa.common;

import org.springframework.data.domain.Page;

public class Pagenation {

    public static final PagingButton getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1;

        int defaultButtonCount = 10;    // 기본적으로 한 페이지에 10개가 들어갈 수 있겠금

        int startPage = (int)(Math.ceil((double) currentPage / defaultButtonCount) -1); // 그냥 공식
        int endPage = startPage + defaultButtonCount - 1;

        if(page.getTotalPages() < endPage) endPage = page.getTotalPages();

        if(page.getTotalPages() == 0 && endPage == 0) endPage = startPage;

        return new PagingButton(currentPage,startPage,endPage);
    }
}
