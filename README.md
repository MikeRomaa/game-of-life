# Conway's Game of Life

Java implementation by Michael Romashov

Created for an AP Computer Science A project


## Table of Contents

- [How do I use this program?](#how-do-i-use-this-program-)
- [What is Conway's Game of Life?](#what-is-conway-s-game-of-life-)
    * [Still Life](#still-life)
    * [Oscillator](#oscillator)
    * [Spaceship](#spaceship)
    * [Guns](#guns)
- [Lets get crazier!](#lets-get-crazier-)
    * [Eaters](#eaters)
    * [Annihilation](#annihilation)
    * [Computing](#computing)


## How do I use this program?

After you download and run the Java archive provided, you will be greeted with a black
screen. Below are the different keybinds you can use to create and run your own structures!

| Keybind       | Function                                                          |
|---------------|-------------------------------------------------------------------|
| Left Mouse    | Paint live cells, Place active blueprint                          |
| Right Mouse   | Paint dead cells (eraser)                                         |
| 1             | Create a **Gosper Glider Gun** blueprint                          |
| 2             | Create a **Pufferfish** blueprint                                 |
| R             | Rotate blueprint                                                  |
| Space         | Manually step through generations                                 |
| Shift + Space | Automatically run through generations (20 generations per second) |
| Enter         | Stop automatically running through generations                    |

## What is Conway's Game of Life?

***Disclaimer**: This is, in no way, a comprehensive explanation of Conway's Game of Life.
THere are definitely things I missed and there may be things I got wrong. If you want to
add on or correct my explanation, feel free to submit a pull request.*

---

To understand what Conway's Game of Life is, we must first understand what a cellular
automata is. A **ceullar automata** is a model that describes how an array of cells
"evolves" every iteration of the model. Simply put, imagine a grid of cells where each
cell is either *alive* or *dead*. Each iteration of the model, we use apply a specific
set of rules to each cell in the grid to determine its next state. These rules are
usually simple "yes" or "no" questions regarding the cell's neighbors, but is not
limited to that. Every iteration, or **generation** of the model, the cells evolve
and can form different structures such as the ones seen below (in the examples below,
every next row is a new generation).

![Simple Ceullar Automata](https://camo.githubusercontent.com/e562148a6c5b7ed4d400bb457a6292eb9209803c12d82fbe100aa83967d0e04a/68747470733a2f2f692e6962622e636f2f4d3237713436572f6175746f6d61746f6e732e6a7067)

Conway's Game of Life is a form of cellular automata, with its own set of rules. The rules
that John H. Conway created are as follows:

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

When cells are randomly set to be live, you will notice that the model tends to be chaotic, with
the cells changing state with what seems to be a random rate or pattern. However, given enough
generations pass, every cell will stabilize and turn into one of the strucures below.

### Still Life

A still life is a structure that does not change in the next generation. They are said to be
stable structures. Pictured below are the **Block** and **Beehive**.

![Block](https://conwaylife.com/w/images/4/48/Block.png)
![Beehive](https://conwaylife.com/w/images/3/3c/Beehive.png)

### Oscillator

An oscillator is a structure that alternates between multiple states before returning to a
previous state and starting the loop again. Here we introduce the idea of a **period**, which
is the amount of generations it takes a structure to return to a previous state and cycle
through its states again. For example, the **Blinker** (left) has a period of 2, meaning it loops
through all of its states every 2 generations. The **Queen Bee Shuttle** (right) has a period of 30.

![Blinker](https://conwaylife.com/w/images/b/b9/Blinker.gif)
![Queen Bee Shuttle](https://conwaylife.com/w/images/5/5c/Queenbeeshuttle.gif)

### Spaceship

A spaceship is a structure that moves after a certain amount of generations. Picture below
are the **Glider** (left; period 4) and the **Lightweight Spaceship** (right; period 4).

![Glider](https://conwaylife.com/w/images/8/81/Glider.gif)
![Lightweight Spaceship](https://conwaylife.com/w/images/2/21/Lwss.gif)

### Guns

A gun is a structure that generates spaceships, as if shooting them outward in a constant stream.
Guns generate a spaceship at a constant rate. For example, the **Gosper Glider Gun** pictured
below creates a glider every 30 generations (period 30). (You may notice that the **Gosper Glider
Gun** is very similar to the **Queen Bee Shuttle** pictured earlier, thats because it acts as the
base for the glidern gun!).

![Gosper Glider Gun](https://conwaylife.com/w/images/b/b6/Gosperglidergun.gif)


## Lets get crazier!

Okay so now that we are at least somewhat familiar with this interesting cellular automaton, lets
see how far we can take it!

### Eaters

An eater is a specific structure, usually a still life, that when collided by a spaceship, will
destroy the spaceship while remiaining intact. Below is an example of a eater specifically made
to destroy **Gliders**.

![Eater](https://i.imgur.com/XjaHmnc.gif)

### Annihilation

If two spaceships are positioned correctly, they can actually annihilate each other! When this
happens, both gliders completely die. Pictured below is the annihilation of two **Gliders**.

![Annihilation](https://i.imgur.com/5zylvTn.gif)

### Computing

If used correctly, annihilation and eats can actually be used to create Turing complete computers!
[This video](https://www.youtube.com/watch?v=Kk2MH9O4pXY) does an excellent job of explaining
and demonstrating this. Somebody even used Game of Life to create a fully functioning model that
simulates the Game of Life... INSIDE THE GAME OF LIFE! A video demonstrating this can be found
[here](https://www.youtube.com/watch?v=xP5-iIeKXE8).
