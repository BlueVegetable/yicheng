package cn.studio.zps.blue.ljy.domain;

public class VideoIntroduce {

	private int id;
	private String title;
	private String content;
	private int courseID;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title=title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content=content;
	}

	public int getCourseID() {
		return this.courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID=courseID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VideoIntroduce videoIntroduce = (VideoIntroduce) o;

		if(id != videoIntroduce.id) return false;
		if(title != null ? !title.equals(videoIntroduce.title) : videoIntroduce.title !=null) return false;
		if(content != null ? !content.equals(videoIntroduce.content) : videoIntroduce.content !=null) return false;
		if(courseID != videoIntroduce.courseID) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (title!=null ? title.hashCode() : 0);
		result = 31 * result + (content!=null ? content.hashCode() : 0);
		result = 31 * result + courseID;
		return result;
	}
}