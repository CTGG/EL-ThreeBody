package dto;

import util.R;
import ai.AI;

public class PreferenceDTO {
    
    /*
     * �û�����,aiLevel,language,resolution��ֵ����ο�R��
     */
    private boolean musicSwitch;
    private boolean effectSwitch;
    private AI.level aiLevel;
    private R.language language;
    /*
     * �ֱ���
     */
    private R.resolution resolution;
    private int volume;
    
    /*
     * getters and setters
     */
	public boolean isMusicSwitch() {
		return musicSwitch;
	}
	public void setMusicSwitch(boolean musicSwitch) {
		this.musicSwitch = musicSwitch;
	}
	public boolean isEffectSwitch() {
		return effectSwitch;
	}
	public void setEffectSwitch(boolean effectSwitch) {
		this.effectSwitch = effectSwitch;
	}
	public AI.level getAiLevel() {
		return aiLevel;
	}
	public void setAiLevel(AI.level aiLevel) {
		this.aiLevel = aiLevel;
	}
	public R.language getLanguage() {
		return language;
	}
	public void setLanguage(R.language language) {
		this.language = language;
	}
	public R.resolution getResolution() {
		return resolution;
	}
	public void setResolution(R.resolution resolution) {
		this.resolution = resolution;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
}
