#pragma once

// 静态顺序表
// 顺序表的容量是在编译期间（静态期间）决定
// 写死在代码里的
/*
typedef struct SeqList {
	int array[100];	// 容量是 100
	int size;		// 当前顺序表里已经有的数据个数
					// 顺便表示了顺序表，最后插入的数据的下标
}	SeqList;
*/

// 初始化的时候 size = 0
// size = -1	// 最后一个有效数据的下标

typedef int SLDataType;

// 动态顺序表
// 顺序表的容量是在运行期间（动态期间）决定
typedef struct SeqList {
	SLDataType *array;
	int capacity;	// 容量
	int size;
}	SeqList;

// 初始化 / 销毁
void SeqListInit(SeqList *seqlist, int capacity);

void SeqListDestroy(SeqList *seqlist);

// 增 / 删 / 改 / 查
// 尾插
void SeqListPushBack(SeqList *seqlist, SLDataType v);
// 头插
void SeqListPushFront(SeqList *seqlist, SLDataType v);
// 根据 pos 下标做插入
void SeqListInsert(SeqList *seqlist, int pos, SLDataType v);

// 尾删
void SeqListPopBack(SeqList *seqlist);
// 头删
void SeqListPopFront(SeqList *seqlist);
// 根据 pos 下标做删除
void SeqListErase(SeqList *seqlist, int pos);

// 修改
// inline 内联函数
static void SeqListModify(SeqList *seqlist, int pos, SLDataType v) {
	seqlist->array[pos] = v;
}

// 查找
// 返回遇到的第一个 v 的下标，没找到，返回 -1
static int SeqListFind(const SeqList *seqlist, SLDataType v) {
	for (int i = 0; i < seqlist->size; i++) {
		if (seqlist->array[i] == v) {
			return i;
		}
	}

	return -1;
}

#include <stdio.h>

// 打印
static int SeqListPrint(const SeqList *seqlist) {
	for (int i = 0; i < seqlist->size; i++) {
		printf("%d ", seqlist->array[i]);
	}
	printf("\n");
}

// 删除第一次遇到的 v
void SeqListRemove(SeqList *seqlist, SLDataType v);

// 删除遇到的所有 v
void SeqListRemoveAll(SeqList *seqlist, SLDataType v);

