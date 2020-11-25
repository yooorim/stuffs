# Pip / PIL module Error

I wanted to make a automation script to crop multiple (more than 100 image) with python.

But terminal showed me those Error.

So I spend 2 hours to solve it but failed, and Seungjoon solved the p 

```python
Error: No available formula or cask with the name "pip".
pip is part of the python formula:
```

---

**Reason**: Anaconda is a environment. But I tried to install something again and again.
So he uninstalled anaconda3 and loaded the Path that is turned when Terminal is loading(Using vi)

**Learn:** understand about Virtual Environments more clearly before I use it.

---

Error situation: No pip was found

```
Traceback (most recent call last):
  File "/Users/macintosh/opt/**anaconda3**/bin/pip", line 5, in <module>
    from pip._internal.cli.main import main
ModuleNotFoundError: No module named 'pip'
```

anaconda is the main problem

```python
vi ~/.bash_profile
```

remove anaconda blabla.

**:wq!**  for exit

```python
conda install anaconda-clean
anaconda-clean --yes

sudo rm -rf /anaconda3
```

remove anaconda3

let's reinstall pip

```python
**curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py**

$ curl https://bootstrap.pypa.io/get-pip.py -o get-pip.py
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100 1842k  100 1842k    0     0   584k      0  0:00:03  0:00:03 --:--:--  584k
macintosh@Macintoshs-MacBook-Pro-2 ~ (master)
$

**python get-pip.py**

DEPRECATION: Python 2.7 reached the end of its life on January 1st, 2020. Please upgrade your Python as Python 2.7 is no longer maintained. pip 21.0 will drop support for Python 2.7 in January 2021. More details about Python 2 support in pip can be found at https://pip.pypa.io/en/latest/development/release-process/#python-2-support pip 21.0 will remove support for this functionality.
Defaulting to user installation because normal site-packages is not writeable
Collecting pip
  Using cached pip-20.2.4-py2.py3-none-any.whl (1.5 MB)
Collecting wheel
  Downloading wheel-0.35.1-py2.py3-none-any.whl (33 kB)
Installing collected packages: pip, wheel
  WARNING: The scripts pip, pip2 and pip2.7 are installed in '/Users/macintosh/Library/Python/2.7/bin' which is not on PATH.
  Consider adding this directory to PATH or, if you prefer to suppress this warning, use —no-warn-script-location.
  WARNING: The script wheel is installed in '/Users/macintosh/Library/Python/2.7/bin' which is not on PATH.
  Consider adding this directory to PATH or, if you prefer to suppress this warning, use —no-warn-script-location.
Successfully installed pip-20.2.4 wheel-0.35.1
macintosh@Macintoshs-MacBook-Pro-2 ~ (master)
```

The problemaic part is,

```python
Consider adding this directory to PATH or, if you prefer to suppress this warning, use —no-warn-script-location.
  WARNING: The script wheel is installed in '/Users/macintosh/Library/Python/2.7/bin' which is not on PATH.
  Consider adding this directory to PATH or, if you prefer to suppress this warning, use —no-warn-script-location.
```

so, go into vi again

```python
vi ~/.bash_profile

**export PATH=$PATH:/Users/macintosh/Library/Python/2.7/bin**
```

put the second line

**:wq!**  for exit

and turn on the terminal again.

```python
pip install pillow
```

Problem solved!