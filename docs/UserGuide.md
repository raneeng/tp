# User Guide

## Introduction

**FlashBang** is a CLI app designed to provide students with a smart way of studying for their modules. The app will manage a limited number of flashcards for a small number of modules, optimized for users who prefer a CLI.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 17 or above installed.
1. Down the latest version of `Duke` from [here](http://link.to/duke).

## Features

### Adding flashcards: `add`

Add a flashcard to a flashcard set.

```bash
add --m [MODULE NAME] --q [QUESTION] --a [ANSWER]
```

**Examples:**
```bash
add --m CS2113 --q "What is OOP?" --a "Object-Oriented Programming"
add --m CS1010 --q "What is a variable?" --a "A storage location in memory with a name"
add --m MA1521 --q "What is the derivative of sin(x)?" --a "cos(x)"
```

### Deleting flashcards: `delete`

To delete one flashcard:

```bash
delete --m [MODULE NAME] --i [INDEX]
```

To delete all flashcards in a set:

```bash
delete --m [MODULE NAME]
```

**Examples:**
```bash
delete --m CS2113 --i 2    # Deletes second flashcard in the module CS2113
delete --m MA1521 --i 5    # Deletes fifth flashcard in the module MA1521
delete --m CS1010          # Deletes all flashcards in the module CS1010
```

### Viewing all flashcards: `view`

```bash
view --all
```

**Example:**
```bash
view --all
```

### Viewing all flashcards in a module without the answers: `flashbang`

```bash
flashbang --m [MODULE NAME]
```

**Example:**
```bash
flashbang --m CS1010
```
```
Question: "What is a variable?"
Reveal answer? (Q to quit) (Y/N)
Y
Answer: "A storage location in memory with a name." 
Next question: "What is a constant?"
Reveal answer? (Q to quit) (Y/N)
Q
Bye!!
```

### Filter flashcards by module: `view`

```bash
view --m [MODULE NAME]
```

**Example:**
```bash
view --m CS2113
```

### Edit flashcard: `edit`

Edits an existing flashcard.

```bash
edit --m [MODULE NAME] --i [INDEX] --q [NEW QUESTION] --a [NEW ANSWER]
```

Or 

```bash
edit --m [MODULE NAME] --i [INDEX]    # Prompts for inputs
```

**App Prompts:**
```
App: New Question: [NEW QUESTION]
App: New Answer: [NEW ANSWER]
```

**Examples:**
```bash
edit --m CS1010 --i 2 --q "What is a constant?" --a "A value that cannot be changed once initialized."
edit --m MA1521 --i 3 --q "What is the integral of 1/x?" --a "ln|x| + C"
edit --m CS2040 --i 4
New Question: "What is a graph?"
New Answer: "A data structure consisting of vertices and edges."
edit --m MA1521 --i 1
New Question: "What is the derivative of e^x?"
New Answer: "e^x"
```

