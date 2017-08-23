package com.pages;

import com.Constants;
import com.pages.deserializers.CreatedBoard.CreatedBoard;
import com.pages.deserializers.CreatedCard.CreatedCard;
import com.pages.deserializers.CreatedList.CreatedList;
import com.pages.serializers.CreateBoard;
import com.pages.serializers.CreateCard;
import com.pages.serializers.CreateList;
import io.restassured.RestAssured;

public class ApiActions{
    private String key = "67a4bb4b40ab1b113903b8bcba3d5ead";
    private String token = "60ac571dd69fe88ced5ad1d5174f92964ef36f094f44dd5be748f7f5d73adff3";

    public CreatedBoard createBoard(String boardName){
        CreateBoard createBoard = new CreateBoard();
        createBoard.setName(boardName);
        createBoard.setKey(key);
        createBoard.setToken(token);

        return RestAssured.given().contentType("application/json").body(createBoard).post(Constants.boardsUrl).then().statusCode(200).extract().as(CreatedBoard.class);
    }

    public CreatedList createList(String listName, String boardId){
        CreateList createList = new CreateList();
        createList.setName(listName);
        createList.setKey(key);
        createList.setToken(token);
        createList.setIdBoard(boardId);

        return RestAssured.given().contentType("application/json").body(createList).post(Constants.listsUrl).then().statusCode(200).extract().as(CreatedList.class);
    }

    public CreatedCard createCard(String cardName, String listId){
        CreateCard createCard = new CreateCard();
        createCard.setName(cardName);
        createCard.setKey(key);
        createCard.setToken(token);
        createCard.setIdList(listId);

        return RestAssured.given().contentType("application/json").body(createCard).post(Constants.cardsUrl).then().statusCode(200).extract().as(CreatedCard.class);
    }
}