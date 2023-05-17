package com.spring.onedaythink.haruchat.mapper;

import com.spring.onedaythink.chat.vo.ChatRoom;
import com.spring.onedaythink.haruchat.vo.*;
import com.spring.onedaythink.user.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HaruChatMapper {

    // 하루봇 랜덤 조회
    public List<HaruChat> selectHaruBot();


    // 채팅 시작 (사용자 하루봇 선택 반영)
    public int insertHaruChatRoom(User user);

    public HaruChatRoom selectHaruChatRoomNo();

    public int insertHaruChatRoomHaru(HaruChatRoomDetail haruChatRoomDetail);

    // 하루봇 채팅방 전체 조회
    public List<HaruChatRoom> selectAllharuChatRoom();

    // 하루봇 채팅방 개별 조회
    public HaruChatRoom selectOneharuChatRoom(HaruChatRoom haruChatRoom);

    // 하루봇 채팅방 요약문 조회
    public HaruChatRoom selectOneSummary(HaruChatRoom haruChatRoom);
    // 하루봇 채팅방 직전 대화 10개 조회
    public List<CurrentMsg> selectPreviousMsg(HaruChatRoom haruChatRoom);

    // 하루봇 채팅방 요약되지 않은 대화 수 조회
    public int selectSummerized(HaruChatRoom haruChatRoom);

    // 하루봇 채팅방 마지막 메세지 조회
    HaruChatMessage selectLastMessage(HaruChatRoom haruChatRoom);

    // 하루봇 채팅메세지 생성
    public int insertHaruChatMsg(HaruChatMessage haruChatMessage);


    // 하루봇 채팅방 나가기
    int updateHaruChatRoomClosed(HaruChatRoom haruChatRoom);

}

