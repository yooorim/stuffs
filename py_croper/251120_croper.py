# https://amanokaze.github.io/blog/Python-Image-Multi-Crop/

import os
from PIL import Image 

for root, dirs, files in os.walk('./'):
    for idx, file in enumerate(files):
        fname, ext = os.path.splitext(file)
        if ext in ['.jpg','.png','.gif']:
            im = Image.open(file)
            width, height = im.size
            
            crop_image = im.crop((((width-1280)/2)+15, 80, 1592, height))
            crop_image.save(file)