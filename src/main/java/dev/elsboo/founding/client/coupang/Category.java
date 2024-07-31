package dev.elsboo.founding.client.coupang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Category {
    WOMAN_FASHION(1001, "여성패션"),
    MAN_FASHION(1002, "남성패션"),
    BEAUTY(1010, "뷰티"),
    BABY(1011, "출산/유아동"),
    FOOD(1012, "식품"),
    KITCHEN(1013, "주방용품"),
    LIVING(1014, "생활용품"),
    HOME_INTERIOR(1015, "홈인테리어"),
    ELECTRONICS(1016, "가전디지털"),
    SPORTS(1017, "스포츠/레저"),
    CAR(1018, "자동차용품"),
    BOOK(1019, "도서/음반/DVD"),
    HOBBY(1020, "완구/취미"),
    OFFICE(1021, "문구/오피스"),
    HEALTH(1024, "헬스/건강식품"),
    DOMESTIC_TRAVEL(1025, "국내여행"),
    OVERSEAS_TRAVEL(1026, "해외여행"),
    PET(1029, "반려동물용품"),
    BABY_FASHION(1030, "유아동패션");

    private int categoryId;
    private String categoryName;

}
