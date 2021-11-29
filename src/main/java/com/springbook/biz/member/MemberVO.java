package com.springbook.biz.member;


public class MemberVO {
	
	private int mSeq ;
	private String mId;
	private String mPassword;
	private String mName;
	private String mBirthday;
	private String mEmail;
	private String mGender;
	private String mTell;
	private String mLicense;
	private String mNickname;
	private String mImgPath;  //나중에 삭제
	private String mIntroduce;
	private String mAccountStatus;
	
	public int getmSeq() {
		return mSeq;
	}
	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmBirthday() {
		return mBirthday;
	}
	public void setmBirthday(String mBirthday) {
		this.mBirthday = mBirthday;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
	public String getmTell() {
		return mTell;
	}
	public void setmTell(String mTell) {
		this.mTell = mTell;
	}
	public String getmLicense() {
		return mLicense;
	}
	public void setmLicense(String mLicense) {
		this.mLicense = mLicense;
	}
	public String getmNickname() {
		return mNickname;
	}
	public void setmNickname(String mNickname) {
		this.mNickname = mNickname;
	}
	public String getmImgPath() {
		return mImgPath;
	}
	public void setmImgPath(String mImgPath) {
		this.mImgPath = mImgPath;
	}
	public String getmIntroduce() {
		return mIntroduce;
	}
	public void setmIntroduce(String mIntroduce) {
		this.mIntroduce = mIntroduce;
	}
	public String getmAccount_status() {
		return mAccountStatus;
	}
	public void setmAccount_status(String mAccount_status) {
		this.mAccountStatus = mAccount_status;
	}
	@Override
	public String toString() {
		return "MemberVO [mSeq=" + mSeq + ", mId=" + mId + ", mPassword=" + mPassword + ", mName=" + mName
				+ ", mBirthday=" + mBirthday + ", mEmail=" + mEmail + ", mGender=" + mGender + ", mTell=" + mTell
				+ ", mLicense=" + mLicense + ", mNickname=" + mNickname + ", mImgPath=" + mImgPath + ", mIntroduce="
				+ mIntroduce + ", mAccountStatus=" + mAccountStatus + "]";
	}
	
	

	
	
	



}
