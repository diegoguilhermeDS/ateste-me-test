import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Infor } from './infor';

describe('Infor', () => {
  let component: Infor;
  let fixture: ComponentFixture<Infor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Infor]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Infor);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
