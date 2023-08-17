-- *HR계정 활성화*
-- system 관리자 계정으로 접속해서, hr계정 접속가능하게 설정

-- HR 사용자 계정 활성화
    -- alter user 사용자계정명: 사용자계정에 대한 속성을 변경
    -- account unlock: 계정을 잠금 상태에서 해제하도록 지시 => 로그인 가능
alter user hr account unlock;

-- HR 사용자 계정의 비밀번호 변경
    -- identified by 비밀번호: 계정의 비밀번호를 설정
alter user hr identified by 1234;