package mid1.review.lang;

public final class EnumClass {
    public static final EnumClass TYPE_CD_1 = new EnumClass("CD_1", 0);
    public static final EnumClass TYPE_CD_2 = new EnumClass("CD_2", 1);
    public static final EnumClass TYPE_CD_3 = new EnumClass("CD_3", 2);
    public static final EnumClass TYPE_CD_4 = new EnumClass("CD_4", 3);

    private final String typeCd;
    private EnumClass(String typeCd, int ordinal) {
        this.typeCd = typeCd;
    }
}
