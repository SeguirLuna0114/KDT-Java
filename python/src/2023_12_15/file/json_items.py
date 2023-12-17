# data/item.json 파일 읽어오기

import json

# json 파일 읽어오기
items = json.load(open('../data/item.json', 'r', encoding='utf-8'))
print(type(items))              # <class 'list'>
print(items)                    # [{'id': '1', 'name': '레몬', 'price': ' 3000',

for item in items:
    print(item['id']+'-'+item['name']+'-'+item['price']+'-'+item['description'])