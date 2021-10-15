package com.progen.games.simlperpg.msg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class TextMessage implements IMessage {

    private final String message;

}
