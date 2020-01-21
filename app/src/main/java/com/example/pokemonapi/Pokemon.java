package com.example.pokemonapi;

import java.util.List;

public class Pokemon {

    private int id;
    private String name;
    private int height;
    private int weight;
    private List abilities;
    private List moves;
    private List stats;
    private List types;

    public Pokemon(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;

    }

    public List getAbilities() {
        return abilities;
    }

    public void setAbilities(List abilities) {
        this.abilities = abilities;
    }

    public List getMoves() {
        return moves;
    }

    public void setMoves(List moves) {
        this.moves = moves;
    }

    public List getStats() {
        return stats;
    }

    public void setStats(List stats) {
        this.stats = stats;
    }

    public List getTypes() {
        return types;
    }

    public void setTypes(List types) {
        this.types = types;
    }
}
