# How to Git Good in 5 easy steps

## Step 0
Know that the [Git book](https://git-scm.com/book/en/v2) probably talks about
your problem, and you can append ``-h`` or ``--help`` to any `git` command to
view either a short or in-depth help message.

## Step 1
Clone repository so you have main working repository (repo) on your computer.
_You only do this once!_

```sh
git clone https://github.com/aebooth/ZorCK2016.git
```

## Step 2
Create your own branch to work on and switch to it using `git checkout`:
```sh
git branch $MY_BRANCH
git checkout $MY_BRANCH
```

## Step 3
Do work editing the code/adding cool stuff. When done with a fair bit of work
*and* testing of your code, add and commit your work on your branch (don't
forget the message):
```sh
git status # figure out what you've changed
git add $FILE_A $FILE_B $FILE_C # add the files you changed and want to commit
# (you can use git add -A to add everything, but be careful)
git commit -m "Short description of work"
# if you want to say more, use git commit and write the longer changes on
# extra lines (the comments in the message in the editor should guide you)
```

## Step 4
To merge your work into the master:
```sh
git checkout master
git pull --rebase
git checkout $MY_BRANCH
git rebase master # if you need to fix merge conflicts, let me know & I'll help
git checkout master
git pull --rebase # if anything changed in master, restart this step
git merge $MY_BRANCH # perform a final fast-forward merge of your branch with master
```

Your branch is now be merged into `master`, you just need to push so everyone 
can `pull` your changes.

```sh
git push
```

Finally, if all that worked, delete your feature branch:

```sh
git branch -d $MY_BRANCH
```

Your branch will be deleted if properly merged.

## Step 5
Repeat steps 2-4 as necessary. You can check on the commit history of a branch
using `git log $BRANCH`, or no `$BRANCH` for the current branch.


IMPORTANT NOTE:
If you are working on a PERMANENT feature branch (e.g. pokemon), you need to 
switch all references to "master" above to your feature branch name ("pokemon").
For all intents and purposes, "pokemon" is now your master branch.