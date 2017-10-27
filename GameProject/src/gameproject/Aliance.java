/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author hugod
 */
public class Aliance {

    private boolean priv;
    private float compatibilityFactor;
    private float power; // the sum of the two allies power multiplied by the compatibility factor
    private Character first;
    private Character second;

    public Aliance(boolean b, float cf, float p, Character f, Character s) {
        this.priv = b;
        this.compatibilityFactor = cf;
        this.power = p;
        this.first = f;
        this.second = s;
    }

    public Aliance() {
    }
    
    public boolean getPriv(){
    return priv;
    }
    public float getCompatibilityFactor(){
    return compatibilityFactor;
    }
    
    public float getPower(){
    return power;
    }
    
    public Character getFirstCharacter(){
    return first;
    }
    
    public Character getSecondCharacter(){
    return second;
    }
    
    public void setPriv(boolean p){
        this.priv = p;
    }
    
    public void setCompatibilityFactor(float cf){
        this.compatibilityFactor = cf;
    }
    
    public void setPower(float p){
        this.power = p;
    }
    
    public void setFirstCharacter(Character f){
    this.first = f;
    }
    
    public void setSecondCharacter(Character s){
    this.second = s;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Aliance)) {
            return false;
        }
        Aliance that = (Aliance) obj;
        if (!(priv == that.priv)) {
            return false;
        }
        if (!(compatibilityFactor == that.compatibilityFactor)) {
            return false;
        }
        if (!(power == that.power)) {
            return false;
        }
        if (!(first.equals(that.first))) {
            return false;
        }
        return second.equals(that.second);
    }
}
