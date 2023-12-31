# Diary

Diary is an app which can save texts and images you give it.
It is mostly developed to help people to stop being annoying and express emotions somewhere

## Design

### Colors
| Hex     | Color                                                    | Name        |
|---------|----------------------------------------------------------|-------------|
| #393BDB | ![#393BDB](https://placehold.co/15x15/393BDB/393BDB.png) | Primary     |
| #292C87 | ![#292C87](https://placehold.co/15x15/292C87/292C87.png) | PrimaryDark |
| #448D76 | ![#448D76](https://placehold.co/15x15/448D76/448D76.png) | Secondary   |
| #BABA80 | ![#BABA80](https://placehold.co/15x15/BABA80/BABA80.png) | MessageText |
| #CBE432 | ![#7F858C](https://placehold.co/15x15/CBE432/CBE432.png) | Green       |
| #FFFFFF | ![#FFFFFF](https://placehold.co/15x15/FFFFFF/FFFFFF.png) | White       |

### Borders

Messages have 3 rounded 20dp and one sharp corner
The buttons in the bottom have rounded 10dp corners only when they do not have neighbours.

## Database

Database have one only scheme which contains date about messages user writes

| Field name | Type   | Description                                 |
|------------|--------|---------------------------------------------|
| id         | Int    | Identificator (is hidden from user)         |
| text       | String | Text of message                             |
| time       | String | Timestamp of message. It displays on screen |


## TODO

[ ] Design
- [x] choose color schemes
- [x] design blocks and their decorations
- [ ] rewrite styles from components to styles so i will add styles to components by one line of xml
- [ ] set text align in messages
- [ ] use themes

[ ] Logic
- [x] scrollable feed on main activity
- [x] usable text field and post button
- [ ] implement image support

[ ] Database
- [x] make app read data from database
- [x] make app write data to database
- [ ] implement message hiding so user will not see it in chat
- [ ] implement image support

[ ] Tests
- [] test...