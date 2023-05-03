package com.spring.onedaythink.chat.Controller;

import com.spring.onedaythink.chat.service.ChatService;
import com.spring.onedaythink.chat.vo.ChatMessage;
import com.spring.onedaythink.chat.vo.ChatRoom;
import com.spring.onedaythink.chat.vo.ChatRoomDetail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/")
public class ChatController {

    private Logger log = LogManager.getLogger("case3");

    @Autowired
    private ChatService chatService;

    // 마지막 메시지 조회
    @GetMapping(value="chat/rooms/{chatRoomNo}/messages")
    public ResponseEntity getLastMessage(@PathVariable int chatRoomNo){
        log.debug("getLastMessage");
        ChatMessage lastMessage = chatService.getLastMessage(ChatRoom.builder().chatRoomNo(chatRoomNo).build());
        return ResponseEntity.ok(lastMessage);
    }

    // 해당 사용자가 가지고 있는 채팅방 목록 조회
    @GetMapping(value = "chat/rooms/{userNo}")
    public ResponseEntity<Object> getCharRooms(@PathVariable int userNo) {
        log.debug("# All Chat Rooms");
        List<ChatRoomDetail> chatRoomDetails = chatService.getChatRooms(ChatRoomDetail.builder().findUserNo(userNo).build());
        return ResponseEntity.ok(chatRoomDetails);
    }

    // 채팅 종료
    @PostMapping(value="chat/rooms/{chatRoomNo}/close")
    public ResponseEntity closeChatRoom(@PathVariable int chatRoomNo){
        log.debug("closeChatRoom");
        int result = chatService.closeChatRoom(ChatRoom.builder().chatRoomNo(chatRoomNo).build());
        return ResponseEntity.ok(result);
    }

    // 채팅방 개설
    @PostMapping(value = "chat/rooms")
    public ResponseEntity<Object> addChatRoom(@RequestBody ChatRoom chatRoom){
        log.debug("# Create Chat Room , name: " + chatRoom.toString());
        int result = chatService.addChatRoom(chatRoom);
        return ResponseEntity.ok(result);
    }

    // 채팅방 요청 승인/거절 관리
    @PostMapping(value = "chat/rooms/status/{roomNo}")
    public ResponseEntity<Object> editRoomStatus(@PathVariable int roomNo) {
        log.debug("room status");

        return ResponseEntity.ok(null);
    }
}
