import os
import nbtlib

directory = 'files'
filenames = []

for root, dirs, files in os.walk(directory):
    for fname in files:
        filenames.append(os.path.join(root, fname))


def gen_size():
    for filename in filenames:
        nbt_file = nbtlib.load(filename)
        size = nbt_file['size']
        text = 'this.put(\"' + filename[:-4].replace('\\', '/') + '\", new BPos('
        c = 0
        for integer in size:
            c += 1
            value = str(integer)[4:-1]
            text += value
            if c != 3:
                text += ','
        text += '));'
        print(text)


def gen_offset():
    for filename in filenames:
        nbt_file = nbtlib.load(filename)
        blocks = nbt_file['blocks']
        text = 'this.put(\"' + filename[:-4].replace('\\', '/') + '\", List.of(\n'
        first = True
        for block in blocks:
            blockstateid = int(block['state'])
            blockinfo = nbt_file['palette'][blockstateid]
            name = blockinfo['Name']
            if name != 'minecraft:structure_block':
                continue
            metadata = block['nbt']['metadata']
            if not first:
                text += ',\n'
            first = False
            text += f'\t\tnew StructureBlock("{metadata}", '
            blockpos = block['pos']
            bpos = 'new BPos('
            c = 0
            for integer in blockpos:
                c += 1
                value = str(integer)[4:-1]
                bpos += value
                if c != 3:
                    bpos += ','
            bpos += '))'
            text += bpos
        text += '\n));'
        print(text)


gen_size()
gen_offset()
