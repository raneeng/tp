# Project Portfolio Page (PPP)

## Overview
FlashBang is a CLI app designed to provide students with a smart way of studying for their modules. The app will manage a limited number of flashcards for a small number of modules, optimized for users who prefer a CLI.

## Summary of Contributions
### Code contributed
![Click here to view] (https://nus-cs2113-ay2425s1.github.io/tp-dashboard/?search=raneeng&breakdown=true&sort=groupTitle%20dsc&sortWithin=title&since=2024-09-20&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other)

### Enhancements implemented:
Command classes
Command class testing
Show flashbang percentage
Show flashbang mistakes

### Contributions to User Guide 
![UG](https://ay2425s1-cs2113-t11-2.github.io/tp/UserGuide.html)
Wrote feature sections: `add`, `delete`, `flashbang`

### Contributions to Developer’s Guide 
![DG](https://ay2425s1-cs2113-t11-2.github.io/tp/DeveloperGuide.html)
Wrote ‘Parser component’ section
Made Parser Partial Class Diagram
Made Parser Delete Sequence Diagram

### Contributions to team-based tasks
Conducting code reviews and providing feedback to ensure quality.
Maintaining the issue tracker
Updating user docs – documenting the target user profile

### Review/mentoring contributions:
![Example 1](https://github.com/AY2425S1-CS2113-T11-2/tp/pull/160)
![Example 2](https://github.com/AY2425S1-CS2113-T11-2/tp/pull/146)

### Contributions beyond the project team:
![Bugs reported in other team's products](https://github.com/raneeng/ped/issues)

## DG extract
#### Structure
Below is a partial class diagram showing the interactions of the `Parser` class.
![Parser class diagram](./diagrams/ParserPartialClassDiagram.jpg)

The sequence diagram below illustrates the interactions taking `parseCommand(“delete --m cs2113 --i 1”)` as an example.
![Sample delete call sequence diagram](./diagrams/ParserDeleteSequenceDiagram.png)

#### Example
How the `Parser` component works:
The `Parser` receives the command input.
It identifies the command type using `parseCommandType`.
Depending on the command type, it creates the corresponding command object (e.g., `AddCommand`).
The created command is executed, producing a `CommandResult`.
The `CommandResult` is then used by `Ui` to provide feedback to the user.
