How to GIT:
1)clone repository so you have main working repo on your computer. You ONLY DO
THIS ONCE!!!
>>git clone https:/github.com/aebooth/ZorCK2016.git

2)create your own branch to work on and switch to it using checkout:
>>git branch [your branch name]
>>git checkout [your branch name]

3)do work editing the code/adding cool stuff. When done with a fair bit of work
AND testing of your code, add and commit your work on your branch 
(don't forget the message):
>>git add [names of all changed files separated by spaces]
    OR to add all of the files you've changed (modified, added, or deleted)
>>git add -A
    Then
>>git commit -m "[description of work done goes here in quotes]"

4)to merge your work into the master you need to follow this process
>>git checkout master
>>git pull
>>git merge [your branch name]
    Here you may need to fix merge conflicts--if it says this needs to happen, 
let me know and I will help you
>>git pull
    Again fix any merge conflicts with my help
>>git push
Your work should now be merged into the main branch and everyone else should be
able to get your code with a pull

5)to continue working, switch back to your working branch:
>>git checkout [your branch name]
You should NOT need to merge again.

6)Repeat the process by checking by repeating steps 3-5 as often as you need to.
You can check the status of your current changes using "git status", and you 
check on the entire project using "git history". 