#pragma once

// ��̬˳���
// ˳�����������ڱ����ڼ䣨��̬�ڼ䣩����
// д���ڴ������
/*
typedef struct SeqList {
	int array[100];	// ������ 100
	int size;		// ��ǰ˳������Ѿ��е����ݸ���
					// ˳���ʾ��˳�������������ݵ��±�
}	SeqList;
*/

// ��ʼ����ʱ�� size = 0
// size = -1	// ���һ����Ч���ݵ��±�

typedef int SLDataType;

// ��̬˳���
// ˳�����������������ڼ䣨��̬�ڼ䣩����
typedef struct SeqList {
	SLDataType *array;
	int capacity;	// ����
	int size;
}	SeqList;

// ��ʼ�� / ����
void SeqListInit(SeqList *seqlist, int capacity);

void SeqListDestroy(SeqList *seqlist);

// �� / ɾ / �� / ��
// β��
void SeqListPushBack(SeqList *seqlist, SLDataType v);
// ͷ��
void SeqListPushFront(SeqList *seqlist, SLDataType v);
// ���� pos �±�������
void SeqListInsert(SeqList *seqlist, int pos, SLDataType v);

// βɾ
void SeqListPopBack(SeqList *seqlist);
// ͷɾ
void SeqListPopFront(SeqList *seqlist);
// ���� pos �±���ɾ��
void SeqListErase(SeqList *seqlist, int pos);

// �޸�
// inline ��������
static void SeqListModify(SeqList *seqlist, int pos, SLDataType v) {
	seqlist->array[pos] = v;
}

// ����
// ���������ĵ�һ�� v ���±꣬û�ҵ������� -1
static int SeqListFind(const SeqList *seqlist, SLDataType v) {
	for (int i = 0; i < seqlist->size; i++) {
		if (seqlist->array[i] == v) {
			return i;
		}
	}

	return -1;
}

#include <stdio.h>

// ��ӡ
static int SeqListPrint(const SeqList *seqlist) {
	for (int i = 0; i < seqlist->size; i++) {
		printf("%d ", seqlist->array[i]);
	}
	printf("\n");
}

// ɾ����һ�������� v
void SeqListRemove(SeqList *seqlist, SLDataType v);

// ɾ������������ v
void SeqListRemoveAll(SeqList *seqlist, SLDataType v);

