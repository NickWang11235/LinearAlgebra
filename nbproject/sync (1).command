git rm --cached .idea -r
git rm --cached lib -r
git rm -- cached "Linear Algebra.iml"
git add src
git commit -m "syncing"
git remote add origin https://github.com/NickWang11235/LinearAlgebra
git checkout -b temp
git push origin temp
git checkout master
git fetch origin master
git reset --hard origin/master
git pull --set-upstream origin master
git checkout -b development
git pull --set-upstream origin development