package vo;

/** 카테고리  클래스 */
public class CategoryAI {

	/** 카테고리 코드 */
	private int categoryCode;
	/** 카테고리명 */
	private String categoryName;

	/** 생성자 */
	public CategoryAI() {
	}

	/** 카테고리 설정 메소드 */
	public void setCategoryCode(int code) {
		categoryCode = code;
	}

	/** 카테고리명 설정 메소드 */
	public void setCategoryName(String Name) {
		categoryName = Name;
	}

	/** 카테고리 반환 메소드 */
	public int getCategoryCode() {
		return categoryCode;
	}

	/** 카테고리명 반환 메소드 */
	public String getCategoryName() {
		return categoryName;
	}
}
