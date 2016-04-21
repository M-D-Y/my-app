/**
 * @since 9 апр. 2016 г.
 */
package ru.mdy.animals;
/**
 * @author Валя
 *
 */
public enum AnimalSounds{
	Cat("Myau"), Dog("Gav"), Cow("Mu-u"), CatDog("Myau-Gav");

	private String sound;

	AnimalSounds(final String sound) {
		this.sound = sound;
	}
	public String getSound(){
		return this.sound;
	}
	
}