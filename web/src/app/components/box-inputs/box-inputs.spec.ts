import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoxInputs } from './box-inputs';

describe('BoxInputs', () => {
  let component: BoxInputs;
  let fixture: ComponentFixture<BoxInputs>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BoxInputs]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BoxInputs);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
