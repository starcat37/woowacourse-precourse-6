package christmas;

public enum ErrorMessages {
    TYPE_NUMBER_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.\n"),
    BETWEEN_NUMBER_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.\n"),
    MENU_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.\n");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
