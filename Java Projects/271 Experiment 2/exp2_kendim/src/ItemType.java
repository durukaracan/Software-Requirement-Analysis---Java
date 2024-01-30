public enum ItemType {
    COSMETIC_ITEM,
    ELECTRONIC_ITEM,
    OFFICE_SUPPLIES_ITEM;

    public static ItemType fromString(String text) {
        for (ItemType itemType : ItemType.values()) {
            if (itemType.name().equalsIgnoreCase(text)) {
                return itemType;
            }
        }
        return null;
    }
}
