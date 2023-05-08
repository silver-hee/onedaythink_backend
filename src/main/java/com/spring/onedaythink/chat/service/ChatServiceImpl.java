package com.spring.onedaythink.chat.service;

import com.spring.onedaythink.chat.mapper.ChatMapper;
import com.spring.onedaythink.chat.vo.ChatMessage;
import com.spring.onedaythink.chat.vo.ChatMessageDetail;
import com.spring.onedaythink.chat.vo.ChatRoom;
import com.spring.onedaythink.chat.vo.ChatRoomDetail;
import com.spring.onedaythink.user.vo.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService{

    private Logger log = LogManager.getLogger("case3");

    @Autowired
    private ChatMapper chatMapper;

    // 채팅방 조회
    @Override
    public List<ChatRoomDetail> getChatRooms(ChatRoomDetail chatRoomDetail) {
        return chatMapper.selectChatRooms(chatRoomDetail);
    }
    @Override
    public int addChatRoom(ChatRoom chatRoom){
        log.debug("add ChatRoom");
        // 기존에 채팅룸이 열려있는지 확인
        int result = chatMapper.selectChatRoomCountByUserNo(chatRoom);
        // 채팅룸이 없다면 추가
        if (result == 0) {
            result = chatMapper.insertChatRoom(chatRoom);
        }
        return result;
    }

    // 채팅방 종료
    @Override
    public int closeChatRoom(ChatRoom chatRoom) {
        log.debug("closeChatRoom");
        return chatMapper.updateChatRoomClosed(chatRoom);
    }

    // 마지막 메세지 조회
    @Override
    public ChatMessage getLastMessage(ChatRoom chatRoom) {
         log.debug("getLastMessage");
         return chatMapper.selectLastMessage(chatRoom);
    }

    @Override
    public List<ChatMessageDetail> getChatMessageDetails(ChatRoomDetail chatRoomDetail){
        return chatMapper.selectChatMessageDetails(chatRoomDetail);
    }

    @Override
    public int addChatMessage(ChatMessageDetail chatMessageDetail){
        return chatMapper.insertChatMessage(chatMessageDetail);
    }

    // admin 전체 회원 조회
    @Override
    public List<ChatRoom> getChatRoomsAdmin(ChatRoom chatRoom) {
        return chatMapper.selectListChatRoomsAdmin(chatRoom);
    }

}
