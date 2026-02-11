-- [ItemPath] 무기 타입이 드러나는 경로명
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('S_FIRE', '불꽃의 검사', 'SWORD', '화염 공격 특화');
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('S_HOLY', '성스러운 기사', 'SWORD', '신성 및 방어 특화');
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('S_SHADOW', '그림자 암살자', 'SWORD', '치명타 및 속도 특화');
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('C_STORM', '폭풍의 파괴자', 'CLUB', '뇌전 및 광역 특화');
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('C_VOID', '공허의 약탈자', 'CLUB', '방어무시 및 고정뎀 특화');
INSERT INTO item_path (path_code, name, item_type, description) VALUES ('C_EARTH', '대지의 수호자', 'CLUB', '군중제어 및 체력 특화');

-- [ItemMetadata] 1강 -> 3강 성장형 이름 (경로 ID는 위 순서대로 1~6 가정)

-- 검: 불꽃 경로 (ID: 1)
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('불씨의 숏소드', 'SWORD', 1, 1);
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('타오르는 불꽃 검', 'SWORD', 1, 2);
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('명검: 홍련의 심판', 'SWORD', 1, 3);

-- 몽둥이: 폭풍 경로 (ID: 4)
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('벼락 맞은 나뭇가지', 'CLUB', 4, 1);
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('진동하는 강철봉', 'CLUB', 4, 2);
INSERT INTO item_metadata (name, item_type, path_id, enhancement_level) VALUES ('천둥의 파괴 방망이', 'CLUB', 4, 3);